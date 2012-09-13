(ns Gandalf.models.team
	(:require 
			  [clojurewerkz.neocons.rest :as nr]
    		  [clojurewerkz.neocons.rest.nodes :as nn]
    		  [clojurewerkz.neocons.rest.relationships :as nrl]))

;; Neo4j Index constants
(def ^:const index-team-name "teamNames")
(def ^:const index-team-name-text "team-name")
(def ^:const index-user-id-key :team-name)


(defn create-team-data [team]
	(let [team-name (:team-name team)
				twitter-name (:twitter-name team)
				team-image (:image team)]
				{  :team-name team-name :twitter-name twitter-name :team-image team-image}))

(defn create-new-team [team]
	(let [team-node (nn/create (create-team-data team))]
		(nn/add-to-index (:id team-node) index-team-name index-team-name-text (:team-name team))
		(println "**** New team created, node id = " (:id team-node))
		team-node))

(defn add-player-to-team [team player]
	(let [rel (nrl/create team player :team-member)]
		rel))