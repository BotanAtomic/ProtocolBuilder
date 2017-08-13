package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ShortcutObjectIdolsPreset extends ShortcutObject implements INetworkType {

    private int protocolId = 492;
    private int presetId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_Shortcut(param1);
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.error = param1.readByte();
         if(this.error < 0)
         {
            throw new Exception("Forbidden value (" + this.error + ") on element of ShortcutBarAddErrorMessage.error.");
         }
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of ShortcutObjectIdolsPreset.presetId.");
         }
    }

}