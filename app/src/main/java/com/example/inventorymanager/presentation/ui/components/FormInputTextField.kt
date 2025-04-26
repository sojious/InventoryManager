package com.example.inventorymanager.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inventorymanager.presentation.theme.Mauve
import com.example.inventorymanager.presentation.theme.primaryBlue

/*@Composable
fun FormInputTextField(
    modifier: Modifier = Modifier,
    fieldTitle: String,
    fieldValue: String,
    onFieldValueChanged: (String) -> Unit,
    enableMultiline:Boolean,
    type: InputFieldType,

    ){

    val keyboardType=when(type){
        InputFieldType.TEXT->KeyboardType.Text
        InputFieldType.NUMBER->KeyboardType.Phone
        InputFieldType.EMAIL->KeyboardType.Email
    }

    val textModifier=if (enableMultiline) Modifier
        .fillMaxWidth()
        .height(70.dp) else Modifier
        .fillMaxWidth()
        .heightIn(47.dp)
    //val borderColor=if (fieldValue.isEmpty()) secondaryDark else secondary
    Column(modifier= modifier.fillMaxWidth(),) {

        Row(modifier=Modifier.padding(bottom = 8.dp)) {
            Text(
                text = fieldTitle,
                fontSize = 12.sp,
                color = Mauve,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "*",
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 2.dp),
                fontSize = 12.sp
            )
        }

        OutlinedTextField(
            modifier= textModifier,
            value =fieldValue ,
            onValueChange =onFieldValueChanged,
            singleLine = !enableMultiline,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            textStyle = TextStyle(fontSize = 12.sp, color = Mauve),
            shape = RoundedCornerShape(8.dp) ,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = primaryBlue,
            ),
        )

    }
}*/
