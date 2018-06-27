An easy to use **CutableTextView** when you need cut long text.


![videotogif_2018 06 27_14 36 36](https://user-images.githubusercontent.com/21290800/41968497-17ca7814-7a1e-11e8-942e-30ce624829b9.gif)


## Gradle
```
dependencies {
    implementation 'com.github.devit951:cutabletextview:0.0.1'
    ...
}
```

## Usage
```
   <com.david.cutabletextview.CutableTextView
        android:id="@+id/ctv_sample"
        android:layout_margin="16dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Some loooooooooooooooooooooooooooooooooooooooooooooooong text"
        app:ctv_lines_to_cut=4"/>
        
```

## Attributes
`app:ctv_lines_to_cut=` cuts as many lines as you want (default 4).

If you want change this value programmatically , call this method `mCutableTextView.setLinesToCut(int lines);`
