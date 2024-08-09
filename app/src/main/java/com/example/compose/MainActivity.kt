package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.screens.EpisodeView
import com.example.compose.ui.screens.LoginScreen
import com.example.compose.ui.screens.TabView
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

//    companion object {
//        private const val STORAGE_PERMISSION_CODE = 23
//    }
//
//    val storageActivityResultLauncher =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
//                if(Environment.isExternalStorageManager()){
//                    Log.e("Error", "Permission denied")
//                } else {
//                    Toast.makeText(this, "Permission is required", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//
//    var selectedFileUri = mutableStateOf<Uri?>(null)
//
//    val fileChooserLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//        result ->
//        if(result.resultCode == Activity.RESULT_OK){
//            result.data?.data?.let {
//                uri ->
//                selectedFileUri.value = uri
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if (checkStoragePermissions()) {
//            setContent {
//                ComposeTheme {
//                    Surface(modifier = Modifier.fillMaxSize()) {
//                       FileChooserApp(fileChooserLauncher, selectedFileUri, this)
//                    }
//                }
//            }
//        } else {
//            setContent {
//                ComposeTheme {
//                    Surface {
//                        Column(
//                            modifier = Modifier.fillMaxSize(),
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            Button(onClick = { requestForStoragePermissions() }) {
//                                Text(text = "Permission is required")
//                            }
//                        }
//                    }
//                }
//            }
//        }

        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                val scrollState = rememberScrollState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.verticalScroll(scrollState)
                    ) {
                        EpisodeView()
                        TabView()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        LoginScreen()
    }
}


/*
// To handle for storage permission which are android 11 and below
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.size > 0) {
                val write = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val read = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if (read && write) {
                    Toast.makeText(this, "Storage Permissions Granted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Storage Permissions Denied", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    // check for storage permission
    private fun checkStoragePermissions(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager()
        } else {
            val write = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            val read = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            return write == PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED
        }
    }

    // request for storage permission
    private fun requestForStoragePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                val intent = Intent()
                intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                val uri: Uri = Uri.fromParts("package", packageName, null)
                intent.setData(uri)
                storageActivityResultLauncher.launch(intent)
            } catch (e: Exception) {
                val intent: Intent = Intent()
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                storageActivityResultLauncher.launch(intent)
                Log.e("Error", "$e")
            }
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                ),
                STORAGE_PERMISSION_CODE
            )
        }
    }
 */