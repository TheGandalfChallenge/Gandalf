(ns Website.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))


(defpartial site-layout [& content]
  (html5
    [:head
      [:title "The Gandalf Challenge"]]
    [:body
      [:div#wrapper
        content]]))


(defpartial player [{:keys [player-name twitter-name]}]
    [:li player-name " "
    	[:a {:href (str "http://twitter.com/" twitter-name)} "@" twitter-name]
    ])

(defpartial players [items]
    [:ul#playerItems ;; set the id attribute
        (map player items)])
