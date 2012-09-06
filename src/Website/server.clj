(ns Website.server
  (:require [noir.server :as server]
  	[Website.models :as models]))

(server/load-views-ns 'Website.views)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
        (models/initialize)
    (server/start port {:mode mode
                        :ns 'Website})))

