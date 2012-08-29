(ns Website.views.welcome
  (:require [Website.views.common :as common]
  			[Website.models.players :as players])
   (:use 
   	[noir.core]
   	[hiccup.page]
   	[hiccup.element]))

(defpartial player [idx {:keys [image player-name twitter-name]}]
			 [:li.player
			   [:div {:class (str "player-frame frame" (+ 1 idx))}
			     [:image {:src image :id player-name}]]
			   [:p 
			     player-name " " [:a {:href (str "http://twitter.com/" twitter-name)} "@" twitter-name]]])

(defpage "/" []
		  (common/site-layout
		  	[:div.hero.centered.cf
		  	  [:div.photos
		  	    [:image.photo {:src "/photos/pete/014.jpg" :width "400" :height "400"}]
		  	    [:image.frame {:src "/img/hero-frame.png"}]]
		  	    [:h1.ir "The Gandalf Challenge"]
		  	    [:div.intro
		  	      [:h2 "The Idea"]
		  	      [:p "Five men enter. One man will leave, victorious, with the greatest hair+beard combo ever."]
		  	      [:p "Starting with a number one buzz cut and a clean-shaven face, players will avoid all forms of hair removal for as long as possible. Last man to get a haircut/trim/shave wins."]
		  	    ]
		  	]
		  	[:div.players.centered
		  	  [:ul
		  	    (map-indexed player players/players)]]))