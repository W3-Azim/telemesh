package com.w3engineers.unicef.telemesh.data.local.messagetable;

import android.annotation.SuppressLint;
import android.arch.persistence.room.ColumnInfo;
import android.support.annotation.NonNull;

import com.w3engineers.unicef.telemesh.TeleMeshChatOuterClass.*;
import com.w3engineers.unicef.telemesh.data.local.db.ColumnNames;
import com.w3engineers.unicef.telemesh.data.local.db.DbBaseEntity;

/**
 * * ============================================================================
 * * Copyright (C) 2018 W3 Engineers Ltd - All Rights Reserved.
 * * Unauthorized copying of this file, via any medium is strictly prohibited
 * * Proprietary and confidential
 * * ----------------------------------------------------------------------------
 * * Created by: Mimo Saha on [24-Oct-2018 at 12:30 PM].
 * * Email: mimosaha@w3engineers.com
 * * ----------------------------------------------------------------------------
 * * Project: telemesh.
 * * Code Responsibility: <Purpose of code>
 * * ----------------------------------------------------------------------------
 * * Edited by :
 * * --> <First Editor> on [24-Oct-2018 at 12:30 PM].
 * * --> <Second Editor> on [24-Oct-2018 at 12:30 PM].
 * * ----------------------------------------------------------------------------
 * * Reviewed by :
 * * --> <First Reviewer> on [24-Oct-2018 at 12:30 PM].
 * * --> <Second Reviewer> on [24-Oct-2018 at 12:30 PM].
 * * ============================================================================
 **/
@SuppressLint("ParcelCreator")
public class ChatEntity extends DbBaseEntity {

    @NonNull
    @ColumnInfo(name = ColumnNames.COLUMN_MESSAGE_ID)
    public String messageId;

    @NonNull
    @ColumnInfo(name = ColumnNames.COLUMN_FRIENDS_ID)
    public String friendsId;

    @ColumnInfo(name = ColumnNames.COLUMN_IS_INCOMING)
    public boolean isIncoming;

    @ColumnInfo(name = ColumnNames.COLUMN_MESSAGE_TYPE)
    public int messageType;

    @ColumnInfo(name = ColumnNames.COLUMN_MESSAGE_TIME)
    public long time;

    @ColumnInfo(name = ColumnNames.COLUMN_MESSAGE_STATUS)
    public int status;

    public String getMessageId() {
        return messageId;
    }

    public ChatEntity setMessageId(String messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getFriendsId() {
        return friendsId;
    }

    public ChatEntity setFriendsId(String friendsId) {
        this.friendsId = friendsId;
        return this;
    }

    public boolean isIncoming() {
        return isIncoming;
    }

    public ChatEntity setIncoming(boolean incoming) {
        isIncoming = incoming;
        return this;
    }

    public int getMessageType() {
        return messageType;
    }

    public ChatEntity setMessageType(int messageType) {
        this.messageType = messageType;
        return this;
    }

    public long getTime() {
        return time;
    }

    public ChatEntity setTime(long time) {
        this.time = time;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ChatEntity setStatus(int status) {
        this.status = status;
        return this;
    }

    public TeleMeshChat toProtoChat() {
        throw new IllegalStateException();
    }

    public ChatEntity toChatEntity(TeleMeshChat teleMeshChat) {
        throw new IllegalStateException();
    }

}