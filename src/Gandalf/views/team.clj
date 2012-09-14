(ns Gandalf.views.team
  (:require [Gandalf.views.common :as common]
            [Gandalf.views.carousel :as carousel]
            [Gandalf.models.team :as teams]
            [Gandalf.models.player :as players])
   (:use 
    [noir.core]
    [hiccup.page]
    [hiccup.element]))

(def rules[{:rule "$50 each to enter"}
           {:rule "No hair removal of any kind"}
           {:rule "Use of grooming products, such as the Gentlmen's Stiffener, accepted"}
           {:rule"Last man standing to win the kitty"}])

(defpartial rules-item [{:keys [rule]}]
  [:li rule])

(defpartial player-item [{:keys [image player-name twitter-name] :as player}]
  (println player)
             [:li.player
               [:div {:class (str "player-frame frame" (+ 1 (rand-int 3)))}
                 [:image {:src image :id player-name}]]
               [:p 
                 player-name " " [:a {:href (str "http://twitter.com/" twitter-name)} "@" twitter-name]]])

(defpage "/team/:team" {:keys [team]}
          (common/site-layout
            [:div.hero.centered.cf
              (carousel/image-carousel)
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
                (map player-item (teams/get-team-members team))
                ]]

            [:div#rules.section.centered.cf
              [:h2 "The Rules"]
              [:image.logo {:src "/img/logo.png"}]
              [:div.content
                [:p "Ya gotta have some ground rules or all of a sudden someone’s gionna come in and be all like “I just cleaned up the bit on my neck” and that my friend is AGAINST THE RULES!"]
                [:ul.list
                (map rules-item rules)]]]))