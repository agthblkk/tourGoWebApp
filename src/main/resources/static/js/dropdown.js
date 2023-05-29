document.addEventListener('DOMContentLoaded', function() {
    const categorySelect = document.getElementById('category-select');
    const tourSelect = document.getElementById('tour-select');

    categorySelect.addEventListener('change', function() {
        const selectedCategory = categorySelect.value;
        const firstWord = selectedCategory.split(' ')[0].toLowerCase();

        const options = Array.from(tourSelect.options);
        options.forEach(function(option) {
            const optionText = option.textContent;
            const optionFirstWord = optionText.split(' ')[0].toLowerCase();
            if (optionFirstWord === firstWord || selectedCategory === 'all') {
                option.style.display = 'block';
            } else {
                option.style.display = 'none';
            }
        });

        tourSelect.selectedIndex = 0;
    });
});
// document.addEventListener('DOMContentLoaded', () => {
//     // Your code here
//     document.getElementById("takeHere").style.backgroundColor = "red";
//     // alert("wtf")
// });