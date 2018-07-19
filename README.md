![cutable_text_view_icon](https://user-images.githubusercontent.com/21290800/42930330-2087c3f0-8b56-11e8-8f4f-b488cbbf702c.png)


[![badge android platform](https://camo.githubusercontent.com/4e7c3559fec3db6e04cd6d800d00fe6515f75260/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d616e64726f69642d627269676874677265656e2e737667)](https://developer.android.com/)
[![badge v0.0.1](https://camo.githubusercontent.com/872e8e7b7893bb2335c27be1f7cac90227dfd255/68747470733a2f2f62616467652e667572792e696f2f67682f626f656e6e656d616e6e2532466261646765732e737667)](https://github.com/Devit951/Mediateka/releases)

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
