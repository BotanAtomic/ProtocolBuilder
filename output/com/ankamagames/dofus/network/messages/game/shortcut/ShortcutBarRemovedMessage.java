package com.ankamagames.dofus.network.messages.game.shortcut;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ShortcutBarRemovedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6224;
    private boolean _isInitialized = false;
    private int barType = 0;
    private int slot = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         if(this.slot < 0 || this.slot > 99)
         {
            throw new Exception("Forbidden value (" + this.slot + ") on element slot.");
         }
         param1.writeByte(this.slot);
    }

    public void deserialize(ICustomDataInput param1) {
         this.barType = param1.readByte();
         if(this.barType < 0)
         {
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarRemovedMessage.barType.");
         }
         this.slot = param1.readByte();
         if(this.slot < 0 || this.slot > 99)
         {
            throw new Exception("Forbidden value (" + this.slot + ") on element of ShortcutBarRemovedMessage.slot.");
         }
    }

}