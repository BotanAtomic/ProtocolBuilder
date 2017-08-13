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

public class ShortcutBarContentMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6231;
    private boolean _isInitialized = false;
    private int barType = 0;
    private Shortcut[] shortcuts;
    private FuncTree _shortcutstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         param1.writeShort(this.shortcuts.length);
         int _loc2_ = 0;
         while(_loc2_ < this.shortcuts.length)
         {
            param1.writeShort((this.shortcuts[_loc2_] as Shortcut).getTypeId());
            (this.shortcuts[_loc2_] as Shortcut).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         Shortcut _loc5_ = null;
         this.barType = param1.readByte();
         if(this.barType < 0)
         {
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarContentMessage.barType.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(Shortcut,_loc4_);
            _loc5_.deserialize(param1);
            this.shortcuts.push(_loc5_);
            _loc3_++;
         }
    }

}