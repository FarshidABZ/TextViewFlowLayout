
# TextViewFlowLayout
Whatsapp and Telegram message layout

If you are wondering how WhatsApp and Telegram handles the time shown in every messages.

For those who don't know:

1. If the message is very short, the text and time are in the same row.
2. If the message is long, the time is in the bottom right corner - the text wrapped around it.


Extended FrameLayout that wrap its content when there is no place in the current line.

## Demonstration

<img src="https://github.com/FarshidABZ/TextViewFlowLayout/blob/master/media/screenshot_1.png" width="250" /> <img src="https://github.com/FarshidABZ/TextViewFlowLayout/blob/master/media/screenshot_2.png" width="250" /> <img src="https://github.com/FarshidABZ/TextViewFlowLayout/blob/master/media/video.gif" width="250"/>


## Usage

In your layout use TextViewFlowLayout as your TextView parent layout:
   
    <com.example.textviewflowlayout.TextViewFlowLayout
        android:layout_width="220dp"
        android:layout_height="wrap_content"
        android:paddingStart="4dp"
        android:paddingEnd="4dp"
        android:paddingBottom="4dp">
        
        <TextView
                android:id="@+id/message"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="start"
                android:maxWidth="220dp"
                android:paddingStart="4dp"
                android:paddingEnd="4dp"
                android:text='@{item.message}'
                tools:text="Hello World!"
                tools:visibility="visible" />

            <androidx.appcompat.widget.AppCompatTextView
                android:id="@+id/time"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="end"
                android:gravity="end"
                android:paddingStart="8dp"
                android:paddingEnd="4dp"
                android:text="12:45 AM"
                android:textSize="10sp"
                tools:ignore="SmallSp"
                tools:text="22:02 AM" />

        </com.example.textviewflowlayout.TextViewFlowLayout>
            
