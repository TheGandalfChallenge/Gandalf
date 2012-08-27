(ns Website.views.common
  (:use [noir.core]
        [hiccup.page]))

;; Links and includes
(def main-links[{:url "/idea/" :text "The Idea"}
                  {:url "/players/" :text "The Players"}
                  {:url "/rules/" :text "The Rules"}
                  {:url "/badgeofhonor/" :text "The Badge of Honor"}
                  {:url "/donate/" :text "Donate"}])

(defpartial link-item [{:keys [url text]}]
            [:li
            ([:a {:href url} text])])


(def includes {:style (include-css "/css/style.css")
               :modernizr.js (include-js "/js/libs/modernizr-2.5.3.min.js")
               :jquery.js (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js")})

(defpartial build-head [incls]
            [:head
             [:title "The Gandalf Challenge"]
             [:meta {:name "description" :content ""}]
             [:meta {:name "author" :content ""}]
             [:meta {:name "viewport" :content "width=device-width"}]
             (map #(get includes %) incls)])

(defpartial build-foot [incls]
    (map #(get includes %) incls)
    [:script "window.jQuery || document.write('<script src=\"js/libs/jquery-1.7.2.min.js\"><\\/script>')"]
  )

(defpartial site-layout [& content]
  (html5
    (build-head [:style :modernizr.js])
    [:body
      [:div#wrapper
      [:div.bar
      [:ul.nav
        (map link-item main-links)]]
        content]
      (build-foot [:jquery.js])]))


; (defpartial player [{:keys [player-name twitter-name]}]
;     [:li player-name " "
;     	[:a {:href (str "http://twitter.com/" twitter-name)} "@" twitter-name]
;     ])

; (defpartial players [items]
;     [:ul#playerItems ;; set the id attribute
;         (map player items)])
