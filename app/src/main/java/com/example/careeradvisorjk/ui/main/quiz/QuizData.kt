package com.example.careeradvisorjk.ui.main.quiz

data class Question(val text: String, val options: List<String>)

object QuizData {
    data class Question(
        val id: Int,
        val text: String,
        val options: List<String>
    )

    // New and improved list of 6 questions
    val questions = listOf(
        Question(1, "Which activity sounds most interesting to you?",
            listOf("Conducting experiments and analyzing data.", "Creating a business plan and managing a team.", "Designing a website or painting a mural.", "Debating philosophy or studying ancient history.")),
        Question(2, "When you read news, what section do you turn to first?",
            listOf("Technology and Health", "Business and Finance", "Entertainment and Culture", "World News and Opinion Editorials")),
        Question(3, "Which of these school projects would you enjoy the most?",
            listOf("Building a working model of a volcano.", "Running a mock-company for a week.", "Directing a short film or play.", "Writing a research paper on a social issue.")),
        Question(4, "What kind of impact do you want to make in your career?",
            listOf("Developing new technologies or making scientific discoveries.", "Building a successful company or creating wealth.", "Creating work that inspires and moves people.", "Working to improve society and help others.")),
        Question(5, "Pick a work environment that best suits you:",
            listOf("A fast-paced laboratory or a tech start-up.", "A corporate office or a bustling marketplace.", "A quiet studio or a collaborative design firm.", "A library, university, or a non-profit organization.")),
        Question(6, "Which set of skills would you most like to develop?",
            listOf("Problem-solving, mathematics, and analytical reasoning.", "Leadership, negotiation, and strategic planning.", "Creativity, visual communication, and storytelling.", "Critical thinking, empathy, and in-depth research."))
    )
}