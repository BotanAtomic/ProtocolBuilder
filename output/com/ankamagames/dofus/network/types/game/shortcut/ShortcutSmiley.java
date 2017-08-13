package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ShortcutSmiley extends Shortcut implements INetworkType {

    private int protocolId = 388;
    private int smileyId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.error);
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element smileyId.");
         }
         param1.writeVarShort(this.smileyId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.error = param1.readByte();
         if(this.error < 0)
         {
            throw new Exception("Forbidden value (" + this.error + ") on element of ShortcutBarAddErrorMessage.error.");
         }
         this.smileyId = param1.readVarUhShort();
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element of ShortcutSmiley.smileyId.");
         }
    }

}