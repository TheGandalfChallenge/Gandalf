(ns Website.models
	(:require [simpledb.core :as db]
            [Website.models.player :as players]))

(defn initialize []
  (db/init)
  (when-not (db/get :players)
    ;;db values need to be initialized.. this should only happen once.
    (players/init!)))