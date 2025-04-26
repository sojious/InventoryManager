package com.example.inventorymanager.presentation.ui.Addproduct


/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(
    modifier: Modifier = Modifier,
    addProductViewModel: AddProductViewModel,
    dashBoardViewModel: DashBoardViewModel,
    navController: NavHostController

) {
    val productId = navController.currentBackStackEntry?.arguments?.getInt("productId")!!
    val product = dashBoardViewModel.products[productId]
    AddProductScreenContent(modifier = modifier,product = product)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreenContent(
    modifier: Modifier = Modifier, product: Product
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {

        val product =
        EditScreenTitleBar(title = "Add", modifier = Modifier.padding(top = 35.dp, bottom = 36.dp))

        Column(
            modifier = Modifier
                .padding(top = 90.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            TitledLine(title = "PRODUCT INFO")

            FormInputTextField(
                fieldTitle = "name", fieldValue = formState.bio,
                enableMultiline = true, type = InputFieldType.TEXT, onFieldValueChanged = {
                    formState.updateBio(it)
                },
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )

            FormInputTextField(
                fieldTitle = "First name",
                fieldValue = formState.firstName,
                enableMultiline = false,
                type = InputFieldType.TEXT,
                onFieldValueChanged = { formState.updateFirstName(it) },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            FormInputTextField(
                fieldTitle = "First name",
                fieldValue = formState.lastName,
                enableMultiline = false,
                type = InputFieldType.TEXT,
                onFieldValueChanged = { formState.updateLastName(it) },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TitledLine(title = "QUANTITY AND PRICE")

            FormInputTextField(
                fieldTitle = "Github profile url",
                fieldValue = formState.githubUrl,
                enableMultiline = false,
                type = InputFieldType.TEXT,
                onFieldValueChanged = { formState.updateGithubUrl(it) },
                modifier = Modifier.padding(top = 16.dp)
            )

            FormInputTextField(
                fieldTitle = "Slack username",
                fieldValue = formState.slackUsername,
                enableMultiline = false,
                type = InputFieldType.TEXT,
                onFieldValueChanged = { formState.updateSlackUserName(it) },
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )

            TitledLine(title = "SUPPLIER INFO")
            CertificateTypeDropDown(
                state = formState,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            FormInputTextField(
                fieldTitle = "Course of study",
                fieldValue = formState.courseOfStudy,
                enableMultiline = false,
                type = InputFieldType.TEXT,
                onFieldValueChanged = { formState.updateCourseOfStudy(it) },
                modifier = Modifier.padding(bottom = 8.dp)
            )

            FormInputTextField(
                fieldTitle = "School name",
                fieldValue = formState.schoolName,
                enableMultiline = false,
                type = InputFieldType.TEXT,
                onFieldValueChanged = { formState.updateSchoolName(it) },
                modifier = Modifier.padding(top = 8.dp)
            )

        }

    }
}









enum class InputFieldType {
    TEXT,
    NUMBER,
    EMAIL
}*/