#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Memory {
public:
    static int total_memory; 
    int size;

    Memory(int x) {
        size = x;
        total_memory += x;
    }

    void free() {
        total_memory -= size;
        size = 0;
    }

    static void show() {
        cout << "Total allocated memory: " << total_memory << endl;
    }
};

int Memory::total_memory = 0;

int main() {
    string command;
    int x;
    vector<Memory*> blocks;

    cout << "Memory Leak Detector Simulation" << endl;
    cout << "Commands: ALLOCATE / FREE / SHOW / EXIT" << endl;

    while (true) {
        cout << "\n> ";
        cin >> command;

        if (command == "ALLOCATE") {
            cout << "Enter memory units to allocate: ";
            cin >> x;
            blocks.push_back(new Memory(x));
            cout << "Allocated " << x << " units." << endl;
        }
        else if (command == "FREE") {
            cout << "Enter memory units to free: ";
            cin >> x;
            bool found = false;
            for (auto &b : blocks) {
                if (b != nullptr && b->size == x) {
                    b->free();
                    delete b;
                    b = nullptr;
                    cout << "Freed " << x << " units." << endl;
                    found = true;
                    break;
                }
            }
            if (!found)
                cout << "No matching block found!" << endl;
        }
        else if (command == "SHOW") {
            Memory::show();
        }
        else if (command == "EXIT") {
            cout << "Exiting simulation..." << endl;
            break;
        }
        else {
            cout << "Invalid command! Try again." << endl;
        }
    }

    // cleanup
    for (auto &b : blocks) {
        if (b != nullptr) {
            delete b;
            b = nullptr;
        }
    }

    return 0;
}
