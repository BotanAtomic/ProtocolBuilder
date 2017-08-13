package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class IdolFightPreparationUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6586;
    private boolean _isInitialized = false;
    private int idolSource = 0;
    private Idol[] idols;
    private FuncTree _idolstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.idolSource);
         param1.writeShort(this.idols.length);
         int _loc2_ = 0;
         while(_loc2_ < this.idols.length)
         {
            param1.writeShort((this.idols[_loc2_] as Idol).getTypeId());
            (this.idols[_loc2_] as Idol).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         Idol _loc5_ = null;
         this.idolSource = param1.readByte();
         if(this.idolSource < 0)
         {
            throw new Exception("Forbidden value (" + this.idolSource + ") on element of IdolFightPreparationUpdateMessage.idolSource.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(Idol,_loc4_);
            _loc5_.deserialize(param1);
            this.idols.push(_loc5_);
            _loc3_++;
         }
    }

}