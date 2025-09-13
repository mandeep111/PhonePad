# Phone Pad Processing Architecture

## Overview
This project implements a configurable phone pad text input system that converts numeric keypad sequences into text, similar to old T9 input systems. The architecture follows SOLID principles with emphasis on extensibility and testability.

## Core Components

### 1. Domain Layer
- **`PhoneKey`**: Record representing a key mapping (digit → letters)
- **`OldPhonePadKeys`**: Concrete implementation of KeyMap for traditional phone layouts

### 2. Service Interfaces
- **`PhonePad`**: Main interface for processing input strings
- **`InputProcessor`**: Handles the core processing logic
- **`KeyMap`**: Abstracts key-to-letter mappings
- **`ProcessingRules`**: Defines character behavior (flush, backspace, valid digits)

### 3. Core Services
- **`BufferProcessor`**: Manages character buffering and letter selection logic
- **`InputProcessorImpl`**: Orchestrates the processing flow using injected dependencies
- **`BasePhonePad`**: Abstract base class providing common functionality

### 4. Configuration & Rules
- **`OldPhonePadRules`**: Implements traditional phone pad behavior (space/# flush, * backspace)
- **`ModernPhonePadRules`**: Alternative rule set for modern phone behavior

### 5. Factory & Builder Pattern
- **`PhoneKeyFactory`**: Creates predefined key mappings for different languages/layouts
- **`PhonePadBuilder`**: Fluent builder for creating configured phone pad instances

## Processing Flow

```
Input String → InputProcessor → BufferProcessor → Output String
                     ↓              ↓
              ProcessingRules    KeyMap
```

1. **Input Processing**: Each character is evaluated by `ProcessingRules`
2. **Character Handling**:
    - **Flush characters** (`#`, ` `): Convert buffer to letter and append to result
    - **Backspace** (`*`): Flush buffer, then remove last result character
    - **Valid digits** (`2-9`): Add to buffer or flush if different key
3. **Buffer Management**: `BufferProcessor` handles letter cycling (e.g., `222` → `C`)

## Key Design Patterns

- **Strategy Pattern**: `ProcessingRules` for different phone pad behaviors
- **Builder Pattern**: `PhonePadBuilder` for flexible configuration
- **Factory Pattern**: `PhoneKeyFactory` for creating key mappings
- **Dependency Injection**: All components depend on interfaces

## Usage Example

```java
PhonePad pad = new PhonePadBuilder()
    .withKeyboard(KeyboardType.LETTERS)
    .withRules(new OldPhonePadRules())
    .withLanguage(LanguageType.ENGLISH)
    .build();

String result = pad.processInput("4433555 555666#"); // Returns "HELLO"
```

## Extensibility Points

- **New Languages**: Add to `LanguageType` enum and `PhoneKeyFactory`
- **New Rules**: Implement `ProcessingRules` interface
- **Custom Layouts**: Create new `KeyMap` implementations
- **Enhanced Processing**: Extend `BufferProcessor` for features like predictive text

## Testing Strategy

- **Unit Tests**: Each component tested in isolation using test doubles
- **Integration Tests**: End-to-end testing via `PhonePad` interface
- **Mock-free Testing**: Uses concrete test implementations to avoid framework dependencies

The architecture prioritizes loose coupling, making it easy to modify behavior without affecting other components.