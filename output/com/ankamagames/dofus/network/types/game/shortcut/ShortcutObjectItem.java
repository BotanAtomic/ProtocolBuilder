package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShortcutObjectItem extends ShortcutObject implements INetworkType {

    private int protocolId = 371;
    private int itemUID = 0;
    private int itemGID = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.itemUID);
         param1.writeInt(this.itemGID);
         param1.writeInt(this.itemUID);
         param1.writeInt(this.itemGID);
         super.serializeAs_ShortcutObject(param1);
         param1.writeInt(this.itemUID);
         param1.writeInt(this.itemGID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.error = param1.readByte();
         if(this.error < 0)
         {
            throw new Exception("Forbidden value (" + this.error + ") on element of ShortcutBarAddErrorMessage.error.");
         }
         this.itemUID = param1.readInt();
         this.itemGID = param1.readInt();
    }

}