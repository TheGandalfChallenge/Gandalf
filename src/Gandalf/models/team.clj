(ns Gandalf.models.team
	(:require 
					[Gandalf.models.player :as players]
			  	[clojurewerkz.neocons.rest :as nr]
    		  [clojurewerkz.neocons.rest.nodes :as nn]
    		  [clojurewerkz.neocons.rest.relationships :as nrl]))

;; Neo4j Index constants
(def ^:const index-team-name "teamNames")
(def ^:const index-team-name-text "name")
(def ^:const index-team-name-key :name)


(defn create-team-data [team]
	(let [team-name (:team-name team)
				twitter-name (:twitter-name team)
				team-image (:image team)]
				{:team-name team-name :twitter-name twitter-name :team-image team-image}))

(defn create-new-team [team]
	(let [team-node (nn/create (create-team-data team))]
		(nn/add-to-index (:id team-node) index-team-name index-team-name-text (:team-name team))
		(println "**** New team created, node id = " (:id team-node))
		team-node))

(defn add-player-to-team [player team]
	(let [rel (nrl/create player team :team-member)]
		rel))

;gets
(defn get-team [team-name]
	(let [team (first (nn/find index-team-name index-team-name-key team-name))]
	;(println team)
	team))

(defn get-team-members [team]
	;(println team)
		(nr/connect! "http://localhost:7474/db/data/")
		(let [ team-members (nn/traverse (:id (get-team team))
												:relationships [{
													:direction "in" 
													:type "team-member"}] 
												:return-filter {
														:language "builtin" 
														:name "all_but_start_node"})]
		(println team-members)
		(map players/create-player-data-from-node team-members)))