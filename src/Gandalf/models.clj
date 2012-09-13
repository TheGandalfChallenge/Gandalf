(ns Gandalf.models
	(:require [clojurewerkz.neocons.rest :as nr]
    		  [clojurewerkz.neocons.rest.nodes :as nn]
    		  [clojurewerkz.neocons.rest.relationships :as nrl]
          [Gandalf.models.player :as players]
          [Gandalf.models.team :as teams]
			  	[Gandalf.models.rule :as rules]))

(defn initialize []  
	(nr/connect! "http://localhost:7474/db/data/")
		(let [
		igloo (teams/create-new-team {:image "/photos/jay/001.jpg":twitter-name "igloodigital" :team-name "igloo"})
		jay (players/create-new-player {:image "/photos/jay/001.jpg" :twitter-name "jaypet" :player-name "jay"})
		igloo-jay (teams/add-player-to-team igloo jay)]))
	; (let [
	; 	  ;rules
	; 	  gandalf-challenge-rule-one (nn/create {:rule "$50 each to enter"})
	; 	  gandalf-challenge-rule-two (nn/create {:rule "No hair removal of any kind"})
	; 	  gandalf-challenge-rule-three (nn/create {:rule "Use of grooming products, such as the Gentlmen's Stiffener, accepted"})
	; 	  gandalf-challenge-rule-four (nn/create {:rule "Last man standing to win the kitty"})
 ;  		  petes-challenge-rule-one (nn/create {:rule "Shave"})

	; 	  ;Rule Set
	; 	  gandalf-challenge (nn/create {:rule-set-name "Gandalf Challenge"})
	; 	  rel (nrl/create gandalf-challenge gandalf-challenge-rule-one :includes-rule)
	; 	  rel (nrl/create gandalf-challenge gandalf-challenge-rule-two :includes-rule)
	; 	  rel (nrl/create gandalf-challenge gandalf-challenge-rule-three :includes-rule)
	; 	  rel (nrl/create gandalf-challenge gandalf-challenge-rule-four :includes-rule)

	; 	  petes-challenge  (nn/create {:rule-set-name "Pets Challenge "})
	; 	  rel   (nrl/create petes-challenge petes-challenge-rule-one :includes-rule)

	; 	  ;Teams
	; 	  igloo (nn/create {:image "/photos/jay/001.jpg":twitter-name "igloodigital" :team-name "igloo"})
	; 	  rel (nrl/create igloo gandalf-challenge :implements-rule-set)
	; 	  (nn/add-to-index (:id igloo) index-teams index-team-name-text (:team-name user))


	; 	  pete-team (nn/create {:image "/photos/pete/001.jpg":twitter-name "petecostello" :team-name "petes"})
	; 	  rel (nrl/create pete-team petes-challenge :implements-rule-set)
	 	  
	;  	  ;Players
	;  	  jay (nn/create {:image "/photos/jay/001.jpg" :twitter-name "jaypet" :player-name "jay"})
	;  	  rel (nrl/create igloo jay :team-member)

	; 	  aaron (nn/create {:image "/photos/aaron/001.jpg" :twitter-name "Gravypower" :player-name "aaron"})
	; 	  rel (nrl/create igloo aaron :team-member)

	; 	  rob (nn/create {:image "/photos/rob/001.jpg":twitter-name "RobEarlam" :player-name "rob"})
	; 	  rel (nrl/create igloo rob :team-member)

	; 	  vic (nn/create {:image "/photos/vic/001.jpg":twitter-name "victornguyen" :player-name "vic"})
	; 	  rel (nrl/create igloo vic :team-member)

	; 	  pete (nn/create {:image "/photos/pete/001.jpg":twitter-name "petecostello" :player-name "pete"})
	; 	  rel (nrl/create igloo pete :team-member)
	; 	  rel (nrl/create pete-team pete :team-member)]))