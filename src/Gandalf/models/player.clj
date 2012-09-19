(ns Gandalf.models.player
	(:require [clojurewerkz.neocons.rest :as nr]
    		  	[clojurewerkz.neocons.rest.nodes :as nn]))

;create
(defn create-player-data [player]
	(let [player-name (:player-name player)
 		  	image (:image player)
	      twitter-name (:twitter-name player)]
	      {:player-name player-name 
		     :image image 
		     :twitter-name twitter-name}))

 (defn create-player-data-from-node [player-node]
 	(let [player (create-player-data (:data player-node))]
 		(println player)
		  {:id (:id player-node) 
		  :player-name (:player-name player) 
		  :image (:image player) 
		  :twitter-name (:twitter-name player)}))

;db
 (defn create-new-player [player]
 	(let [player-node (nn/create (create-player-data player))]
 		player-node))


(defn get-player [player-id]
	(println player-id)
 	(create-player-data-from-node  (nn/get player-id))
)