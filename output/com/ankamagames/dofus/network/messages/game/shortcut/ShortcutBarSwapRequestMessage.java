package com.ankamagames.dofus.network.messages.game.shortcut;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ShortcutBarSwapRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6230;
    private boolean _isInitialized = false;
    private int barType = 0;
    private int firstSlot = 0;
    private int secondSlot = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         if(this.firstSlot < 0 || this.firstSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.firstSlot + ") on element firstSlot.");
         }
         param1.writeByte(this.firstSlot);
         if(this.secondSlot < 0 || this.secondSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.secondSlot + ") on element secondSlot.");
         }
         param1.writeByte(this.secondSlot);
    }

    public void deserialize(ICustomDataInput param1) {
         this.barType = param1.readByte();
         if(this.barType < 0)
         {
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarSwapRequestMessage.barType.");
         }
         this.firstSlot = param1.readByte();
         if(this.firstSlot < 0 || this.firstSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.firstSlot + ") on element of ShortcutBarSwapRequestMessage.firstSlot.");
         }
         this.secondSlot = param1.readByte();
         if(this.secondSlot < 0 || this.secondSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.secondSlot + ") on element of ShortcutBarSwapRequestMessage.secondSlot.");
         }
    }

}