package com.example.compose.ui.screens

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment

@Composable
fun FileChooserApp(
    fileChooserLauncher: ActivityResultLauncher<Intent>,
    selectedFileUri: MutableState<Uri?>,
    context: Activity
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "*/*"
            }
            fileChooserLauncher.launch(intent)
        }) {
            Text(text = "Choose file")
        }

        selectedFileUri?.let { uri ->
            Text(text = "${uri.value?.let { getFileName(context, it) }}")
        }
    }
}

private fun getFileName(context: Activity, uri: Uri): String? {
    var result: String? = null
    if (uri.scheme == "content") {
        context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                result = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"))
            }
        }
    }
    return result
}
