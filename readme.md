# Test uselessness criteria
- Desired behavior has not changed - test crashed
- Desired behavior has changed - test did not fail

# Characteristics of ideal tests
- Check everything that is important, but do not fix the unimportant.
- Balance between number and reach
- Fast and easy

# Terms:
1. **Component** - service / component test without dependencies
2. **Integration** - service / component test with dependencies
3. **E2E** - use case test

# Cons of blindly writing tests
E2E tests: 
- Do not scale
- Fragile

Component: 
- Partial, not full

# Solution: Fractal testing
Includes characteristics of ideal tests and excludes test uselessness criteria

## Cases

### Broken component test:
![img.png](images/component.png)

### Broken integration test:
![img_1.png](images/integration.png)

### Broken contract: 
![img_2.png](images/contract.png)

### Broken Е2Е:
![img_3.png](images/e2e.png)

# Sources used
- [Дмитрий Карловский - Фрактальное тестирование](https://habr.com/ru/post/510824/)
- [Евгений Борисов, Кирилл Толкачев — Проклятие Spring Test](https://www.youtube.com/watch?v=7mZqJShu_3c&t=1644s&ab_channel=JUG.ru)
- [Кирилл Толкачёв — Тестируем и плачем вместе со Spring Boot Test](https://www.youtube.com/watch?v=uc-cfX-5wQA&ab_channel=Heisenbug)