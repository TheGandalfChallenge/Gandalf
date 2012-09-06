(ns Gandalf.models.player
	(:require [simpledb.core :as db]))

;; Gets

;; Gets the players from the database
(defn all []
  (vals (db/get :players)))


;; Operations
(defn- store! [{image :image playername :player-name  twittername :twitter-name :as player}]
  (db/update! :players assoc playername player))


(defn init! []
    (db/put! :players {})
    (store! {:image "/photos/jay/001.jpg" :player-name "jay" :twitter-name "jaypet"})
    (store! {:image "/photos/aaron/001.jpg" :player-name "aaron" :twitter-name "Gravypower"})
    (store! {:image "/photos/rob/001.jpg" :player-name "rob" :twitter-name "RobEarlam"})
    (store! {:image "/photos/vic/001.jpg" :player-name "vic" :twitter-name "victornguyen"})
    (store! {:image "/photos/pete/001.jpg" :player-name "pete" :twitter-name "petecostello"}))