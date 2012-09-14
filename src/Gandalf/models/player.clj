(ns Gandalf.models.player
	(:require [clojurewerkz.neocons.rest :as nr]
    		  	[clojurewerkz.neocons.rest.nodes :as nn]))

;create
 (defn create-player-data [player-node]
 	(let [player(:data player-node)]
 	(let [player-name (:player-name player)
 		    image (:image player)
	    	twitter-name (:twitter-name player)]
 				{:id (:id player-node) :player-name player-name :image image :twitter-name twitter-name})))

;db
 (defn create-new-player [player]
 	(let [player-node (nn/create (create-player-data player))]
 		player-node))