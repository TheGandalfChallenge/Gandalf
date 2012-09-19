(ns Gandalf.views.admin
  (:require [noir.validation :as vali]
            [noir.response :as resp]
            [clojure.string :as string]
            [Gandalf.views.common :as common]
            [Gandalf.models.player :as players]
            [Gandalf.models.team :as teams])
   (:use 
    [noir.core]
    [hiccup.page]
    [hiccup.element]
    [hiccup.form]))

(defpartial error-text [errors]
            [:span (string/join "" errors)])

(defpartial player-fields[{:keys [player-name image twitter-name]}]
            (vali/on-error :player-name error-text)
            (text-field {:placeholder "Player Name"} :player-name player-name)
            (vali/on-error :image error-text)
            (text-field {:placeholder "Image"} :image image)
            (vali/on-error :twitter-name error-text)
            (text-field {:placeholder "Twitter Name"} :twitter-name twitter-name)
  )

(defpartial player-item [{:keys [image player-name twitter-name id] :as player}]
            [:li
             (link-to (str "admin/edit/" id) player-name)])

(defpage "/team/:team/admin" {:keys [team]}
  (common/admin-layout team
    [:ul.team-players
      (map player-item (teams/get-team-members team))
    ]))

(defpage "/team/:team/admin/edit/:player-id" {:keys [team player-id]}
  (common/admin-layout team
      (form-to [:post (str "/team/" team "/admin/edit/" player-id)]
        (player-fields (players/get-player (Integer/parseInt player-id)) )
        )
    ))

(defpage [:post "/team/:team/admin/edit/:player-id"] {:keys [team player-id]})