(ns Gandalf.views.common
  (:use [noir.core]
        [hiccup.page]
        [hiccup.element]))

(def main-links[{:url "#idea" :text "The Idea"}
                {:url "#players" :text "The Players"}
                {:url "#rules" :text "The Rules"}
                ;{:url "#badgeofhonor" :text "The Badge of Honor"}
                {:url "http://vic.cancercouncilfundraising.org.au/thegandalfchallenge" :text "Donate" :cls "donate"}])

(def includes {:style (include-css "/css/style.css")
               :modernizr.js (include-js "/js/libs/modernizr-2.5.3.min.js")
               :jquery.js (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js")
               :underscore.js (include-js "/js/libs/underscore.js")
               :iskip.js (include-js "/js/libs/jquery.iskip.js")
               :preloader.js (include-js "/js/libs/igloo.preloader.js")
               :plugins.js (include-js "/js/plugins.js")
               :script.js (include-js "/js/script.js")})

(defpartial link-item [{:keys [url cls text]}]
            [:li {:class cls}
             (link-to url text)])

(defpartial build-head [incls]
            [:head
             [:title "The Gandalf Challenge"]
             [:meta {:name "description" :content ""}]
             [:meta {:name "author" :content ""}]
             [:meta {:name "viewport" :content "width=device-width"}]
             (map includes incls)])

(defpartial build-foot [incls]
            (map includes incls)
            [:script "window.jQuery || document.write('<script src=\"/js/libs/jquery-1.7.2.min.js\"><\\/script>')"])

(defpartial site-layout [& content]
            (html5
              (build-head [:style :modernizr.js])
              [:body
                [:div.bar
                [:ul.centered.cf
                  (map link-item main-links)]]
                  content
                (build-foot [:jquery.js :underscore.js :iskip.js :preloader.js :plugins.js :script.js])]))