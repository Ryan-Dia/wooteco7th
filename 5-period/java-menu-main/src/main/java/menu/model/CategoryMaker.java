package menu.model;

import menu.utils.NumberGenerator;

public class CategoryMaker {
    private final menu.utils.NumberGenerator numberGenerator;

    public CategoryMaker(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Category run() {
        return Category.findByNumber(numberGenerator.generate());
    }

}

