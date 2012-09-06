(ns Website.views.carousel
  (:use [noir.core]
        [hiccup.page]
        [hiccup.element]))

(defpartial image-carousel []
				[:div.photos
                [:image.frame {:src "/img/hero-frame.jpg"}]
                [:image.photo {:src "/photos/pete/014.jpg" :width "400" :height "400"}]])