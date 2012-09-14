(ns Gandalf.server
  (:require [noir.server :as server]
  					[clojurewerkz.neocons.rest :as nr]
  					[Gandalf.models :as models]))

(server/load-views-ns 'Gandalf.views)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (models/initialize)
    (nr/connect! "http://localhost:7474/db/data/")
    (server/start port {:mode mode
                        :ns 'Gandalf})))

