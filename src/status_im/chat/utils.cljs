(ns status-im.chat.utils
  (:require [status-im.chat.constants :as chat.constants]))

(defn add-message-to-db
  ([db add-to-chat-id chat-id message] (add-message-to-db db add-to-chat-id chat-id message true))
  ([db add-to-chat-id chat-id {:keys [message-id] :as message} new?]
   (let [prepared-message (assoc message
                                 :chat-id chat-id
                                 :new? (if (nil? new?) true new?))]
     (update-in db [:chats add-to-chat-id :messages] assoc message-id prepared-message))))

(defn command-name [{:keys [name]}]
  (str chat.constants/command-char name))
