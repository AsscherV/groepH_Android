/*==============================================================================
            Copyright (c) 2012-2013 QUALCOMM Austria Research Center GmbH.
            All Rights Reserved.
            Qualcomm Confidential and Proprietary

@file
    BookOverlayView.java

@brief
    Custom View to display the book overlay data

==============================================================================*/
package com.qualcomm.QCARSamples.CloudRecognition.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import be.kdg.groeph.R;

/** Custom View with Book Overlay Data */
public class WaypointOverlayView extends RelativeLayout
{
    public WaypointOverlayView(Context context)
    {
        this(context, null);
    }


    public WaypointOverlayView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }


    public WaypointOverlayView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        inflateLayout(context);

    }


    /** Inflates the Custom View Layout */
    private void inflateLayout(Context context)
    {

        final LayoutInflater inflater = LayoutInflater.from(context);

        // Generates the layout for the view
        inflater.inflate(R.layout.bitmap_layout, this, true);
    }


    /** Sets Waypoint label in View */
    public void setWaypointLabel(String waypointLabel)
    {
        TextView tv = (TextView) findViewById(R.id.custom_view_label);
        tv.setText(waypointLabel);
    }


    /** Sets Book Author in View */
    public void setWaypointDescription(String waypointDescription)
    {
        TextView tv = (TextView) findViewById(R.id.custom_view_description);
        tv.setText(waypointDescription);
    }

    public void setWaypointLattitude(String waypointLattitude)
    {
        //TextView tv = (TextView) findViewById(R.id.custom_view_lattitude);
        //tv.setText(waypointLattitude);
    }

    public void setWaypointLongitude(String waypointLongitude)
    {
        //TextView tv = (TextView) findViewById(R.id.custom_view_longitude);
        //tv.setText(waypointLongitude);
    }


    /** Sets Book Cover in View from a bitmap */
    public void setCoverViewFromBitmap(Bitmap coverWaypoint)
    {
        //ImageView iv = (ImageView) findViewById(R.id.custom_view_waypoint_cover);
        //iv.setImageBitmap(coverWaypoint);
    }

}
