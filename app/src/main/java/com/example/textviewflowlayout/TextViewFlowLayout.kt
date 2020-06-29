package com.example.textviewflowlayout

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * Created by Farshid Abazari
 * Contact farshidabazari@gmail.com
 *
 * Whatsapp and telegram text message layout container
 * */

class TextViewFlowLayout constructor(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs) {
    private val textView by lazy { getChildAt(0) as TextView }
    private val containerView by lazy { getChildAt(1) }

    private val viewPartMainLayoutParams by lazy { textView.layoutParams as LayoutParams }
    private val viewPartSlaveLayoutParams by lazy { containerView.layoutParams as LayoutParams }
    private var containerWidth = 0
    private var containerHeight = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)

        if (widthSize <= 0) {
            return
        }

        val availableWidth = widthSize - paddingLeft - paddingRight

        val textViewWidth =
            textView.measuredWidth + viewPartMainLayoutParams.leftMargin + viewPartMainLayoutParams.rightMargin

        val textViewHeight =
            textView.measuredHeight + viewPartMainLayoutParams.topMargin + viewPartMainLayoutParams.bottomMargin

        containerWidth =
            containerView.measuredWidth + viewPartSlaveLayoutParams.leftMargin + viewPartSlaveLayoutParams.rightMargin

        containerHeight =
            containerView.measuredHeight + viewPartSlaveLayoutParams.topMargin + viewPartSlaveLayoutParams.bottomMargin

        val viewPartMainLineCount = textView.lineCount
        val viewPartMainLastLineWidth =
            if (viewPartMainLineCount > 0) textView.layout.getLineWidth(viewPartMainLineCount - 1) else 0.0f

        widthSize = paddingLeft + paddingRight
        var heightSize = paddingTop + paddingBottom

        if (viewPartMainLineCount > 1 && viewPartMainLastLineWidth + containerWidth < textView.measuredWidth) {
            widthSize += textViewWidth
            heightSize += textViewHeight
        } else if (viewPartMainLineCount > 1 && viewPartMainLastLineWidth + containerWidth >= availableWidth) {
            widthSize += textViewWidth
            heightSize += textViewHeight + containerHeight
        } else if (viewPartMainLineCount == 1 && textViewWidth + containerWidth >= availableWidth) {
            widthSize += textView.measuredWidth
            heightSize += textViewHeight + containerHeight
        } else {
            widthSize += textViewWidth + containerWidth
            heightSize += textViewHeight
        }

        /**
         * If you are showing user name on each row, calculate user name width and add it to the
         * with of message and time if the width of them is lower than user name
         *
         * you can remove it if you want or improve the logic by passing a boolean variable to the
         * TextViewFlowLayout by Attributes to turn on/off this feature
         *  */

        val usernameWidth = (parent as ConstraintLayout).getChildAt(0).measuredWidth

        if (usernameWidth > textViewWidth + containerWidth) {
            widthSize = usernameWidth
        }

        setMeasuredDimension(widthSize, heightSize)

        super.onMeasure(
            MeasureSpec.makeMeasureSpec(widthSize, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(heightSize, MeasureSpec.EXACTLY)
        )
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        textView.layout(
            paddingLeft,
            paddingTop,
            textView.width + paddingLeft,
            textView.height + paddingTop
        )

        containerView.layout(
            right - left - containerWidth - paddingRight,
            bottom - top - paddingBottom - containerHeight,
            right - left - paddingRight,
            bottom - top - paddingBottom
        )
    }
}