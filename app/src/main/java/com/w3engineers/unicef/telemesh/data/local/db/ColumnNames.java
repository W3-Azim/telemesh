package com.w3engineers.unicef.telemesh.data.local.db;

/*
 * ****************************************************************************
 * * Copyright © 2018 W3 Engineers Ltd., All rights reserved.
 * *
 * * Created by:
 * * Name : Ahmed Mohmmad Ullah (Azim)
 * * Date : 2/15/18
 * *
 * * Purpose: Sample of ROOM model column names
 * *
 * * Last Edited by : SUDIPTA KUMAR PAIK on 12/21/17.
 * * History: Comment Added
 * * 1:
 * * 2:
 * *
 * * Last Reviewed by : SUDIPTA KUMAR PAIK on 3/19/18.
 * ****************************************************************************
 */

import com.w3engineers.ext.strom.application.data.helper.local.base.BaseColumnNames;

public interface ColumnNames extends BaseColumnNames {
    //Users table
    String COLUMN_USER_FIRST_NAME = "user_first_name";
    String COLUMN_USER_LAST_NAME = "user_last_name";
    String COLUMN_USER_AVATAR = "avater";
    String COLUMN_USER_MESH_ID = "mesh_id";
    String COLUMN_USER_CUSTOM_ID = "custom_id";
    String COLUMN_USER_TYPE = "user_type";
    String COLUMN_USER_LAST_ONLINE_TIME = "last_online_time";
    String COLUMN_USER_IS_ONLINE = "is_online";


    /**
     * Message table column
     */
    String COLUMN_MESSAGE_ID = "message_id";
    String COLUMN_FRIENDS_ID = "friends_id";
    String COLUMN_MESSAGE = "message";
    String COLUMN_IS_INCOMING = "is_incoming";
    String COLUMN_MESSAGE_TYPE = "message_type";
    String COLUMN_MESSAGE_TIME = "time";
    String COLUMN_MESSAGE_STATUS = "message_status";

    /**
     * Survey table column
     */
    String COLUMN_SENDER_ID = "sender_id";
    String COLUMN_SURVEY_ID = "survey_id";
    String COLUMN_SURVEY_TITLE = "survey_title";
    String COLUMN_SURVEY_FORM = "survey_form";
    String COLUMN_START_TIME = "start_time";
    String COLUMN_END_TIME = "end_time";
    String COLUMN_VENDOR_NAME = "vendor_name";
    String COLUMN_IS_SUBMITTED = "is_submitted";
    String COLUMN_SURVEY_ANS = "survey_answer";
}