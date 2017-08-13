package com.ankamagames.dofus.network.messages.game.shortcut;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.shortcut.Shortcut;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class ShortcutBarRefreshMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6229;
    private boolean _isInitialized = false;
    private int barType = 0;
    private Shortcut shortcut;
    private FuncTree _shortcuttree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         param1.writeShort(this.shortcut.getTypeId());
         this.shortcut.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.barType = param1.readByte();
         if(this.barType < 0)
         {
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarRefreshMessage.barType.");
         }
         int _loc2_ = param1.readUnsignedShort();
         this.shortcut = ProtocolTypeManager.getInstance(Shortcut,_loc2_);
         this.shortcut.deserialize(param1);
    }

}