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
                [:image.frame {:src "/img/hero-frame.jpg"}]
                [:image.photo {:src "/photos/pete/014.jpg" :width "400" :height "400"}]]
                [:h1.ir "The Gandalf Challenge"]
                [:div.content
                  [:h2 "The Idea"]
                  [:p "Five men enter. One man will leave, victorious, with the greatest hair+beard combo ever."]
                  [:p "Starting with a number one buzz cut and a clean-shaven face, players will avoid all forms of hair removal for as long as possible. Last man to get a haircut/trim/shave wins."]
                ]
            ]
            [:div#players.section.centered
              [:h2 "The Players"]
              [:ul.cf
                (map-indexed player players/players)]]

            [:div#rules.section.centered.cf
              [:h2 "The Rules"]
              [:image.logo {:src "/img/logo.png"}]
              [:div.content
                [:p "Ya gotta have some ground rules or all of a sudden someone’s gionna come in and be all like “I just cleaned up the bit on my neck” and that my friend is AGAINST THE RULES!"]
                [:ul.list
                  [:li "$50 each to enter"]
                  [:li "No hair removal of any kind"]
                  [:li "Use of grooming products, such as the Gentlmen's Stiffener, accepted"]
                  [:li "Last man standing to win the kitty"]]]]))