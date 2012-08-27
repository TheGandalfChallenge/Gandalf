(ns Website.views.welcome
  (:require [Website.views.common :as common])
   (:use [noir.core]
        [hiccup.page]))


(defpage "/" []
  (common/site-layout
    [:p "test"]))
; (defpage "/" []
;   (common/site-layout   
;     [:h1 "The Gandalf Challenge"]
;     [:p "Five men enter. One man will leave, victorious, with the greatest hair+beard combo ever."]
;   	[:h2 "The Challenge"]
;     [:p "Starting with a number one buzz cut and a clean-shaven face, players will avoid all forms of hair removal for as long as possible. Last man to get a haircut/trim/shave wins."]
;     [:ul 
;     	[:li "$50 each to enter"]
;     	[:li "No hair removal of any kind"]
;     	[:li "Use of grooming products, such as the "
;     	  [:a {:href "http://www.captainfawcett.com/"} "Gentlmen's Stiffener"] 
;     	  ", accepted"]
;     	[:li "Last man standing to win the kitty"]
;     ]
;     [:h2 "Players"]
;     (common/players [
;     		{:player-name "Aaron Job" :twitter-name "Gravypower"}
;     		{:player-name "Jay Pettigrew" :twitter-name "Jaypet"}
;     		{:player-name "Pete Costello" :twitter-name "Petecostello"}
;     		{:player-name "Rob Earlam" :twitter-name "Robearlam"}
;     		{:player-name "Victor Nguyen" :twitter-name "Victornguyen"}
;     	])
;     [:p "powered by " [:a {:href "http://webnoir.org"} "Noir"] " The Clojure web framework" ]
    
;   )
; )