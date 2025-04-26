package com.example.inventorymanager.presentation.ui.components



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.inventorymanager.presentation.theme.primaryBlue


@Composable
fun EditScreenTitleBar(
    modifier: Modifier = Modifier,
    title: String,
){
    ConstraintLayout(
        modifier = modifier.fillMaxWidth(),
    ) {

        val (backArrow,titleText) = createRefs()
        IconButton(
            modifier= Modifier
                .size(16.dp)
                .constrainAs(backArrow) {
                    start.linkTo(parent.start, 24.dp)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            onClick = {},
            content = {}
        )

        Text(
            text = title,
            color = primaryBlue,
            fontSize =16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            modifier=Modifier.constrainAs(titleText){
                centerHorizontallyTo(parent)
                top.linkTo(parent.top)
                width= Dimension.value(200.dp)
            },

            )
    }
}

@Preview
@Composable
fun YouHrTitleBarPreview(){
    Surface {
        EditScreenTitleBar(
            title = "Interview With Candidate For Product Design Role",
            //onBackArrowClicked = {},
        )
    }
}

