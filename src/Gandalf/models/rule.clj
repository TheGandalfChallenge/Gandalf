(ns Gandalf.models.rule
	(:require [clojurewerkz.neocons.rest :as nr]
    		  [clojurewerkz.neocons.rest.nodes :as nn]))


(defn creat-rule-data [rule]
	(let [rule-text(:rule-text rule)]
		{:rule-text rule-text}))

(defn creat-new-rule [rule]
	(let [rule-node (nn/create (creat-rule-data rule))]
		rule-node))