package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockContentInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildInformationsPaddocksMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5959;
    private boolean _isInitialized = false;
    private int nbPaddockMax = 0;
    private PaddockContentInformations[] paddocksInformations;
    private FuncTree _paddocksInformationstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.nbPaddockMax < 0)
         {
            throw new Exception("Forbidden value (" + this.nbPaddockMax + ") on element nbPaddockMax.");
         }
         param1.writeByte(this.nbPaddockMax);
         param1.writeShort(this.paddocksInformations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.paddocksInformations.length)
         {
            (this.paddocksInformations[_loc2_] as PaddockContentInformations).serializeAs_PaddockContentInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PaddockContentInformations _loc4_ = null;
         this.nbPaddockMax = param1.readByte();
         if(this.nbPaddockMax < 0)
         {
            throw new Exception("Forbidden value (" + this.nbPaddockMax + ") on element of GuildInformationsPaddocksMessage.nbPaddockMax.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PaddockContentInformations();
            _loc4_.deserialize(param1);
            this.paddocksInformations.push(_loc4_);
            _loc3_++;
         }
    }

}