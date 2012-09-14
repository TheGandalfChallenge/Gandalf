(ns Gandalf.views.admin
  (:require [noir.validation :as vali]
            [noir.response :as resp]
            [Gandalf.views.common :as common]
            [Gandalf.models.player :as players]
            [Gandalf.models.team :as teams])
   (:use 
    [noir.core]
    [hiccup.page]
    [hiccup.element]))

(defpartial player-item [{:keys [image player-name twitter-name id] :as player}]
            [:li
             (link-to (str "admin/edit/" id) player-name)])

(defpage "/team/:team/admin" {:keys [team]}
	(common/admin-layout team
		[:ul.team-players
			(map player-item (teams/get-team-members team))
		]))


(defpage "/team/:team/admin/edit/:player-name" {:keys [team player-id]}
  (common/admin-layout team
      (form-to [:post ])
    ))