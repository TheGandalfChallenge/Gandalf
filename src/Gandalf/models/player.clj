(ns Gandalf.models.player
	(:require [clojurewerkz.neocons.rest :as nr]
    		  	[clojurewerkz.neocons.rest.nodes :as nn]))

 (defn create-player-data [player]
 	(let [player-name (:player-name player)
 		    image (:image player)
	    	twitter-name (:twitter-name player)]
 				{:player-name player-name :image image :twitter-name twitter-name}))


 (defn create-new-player [player]
 	(let [player-node (nn/create (create-player-data player))]
 		player-node))