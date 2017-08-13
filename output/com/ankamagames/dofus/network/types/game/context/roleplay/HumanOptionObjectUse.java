package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HumanOptionObjectUse extends HumanOption implements INetworkType {

    private int protocolId = 449;
    private int delayTypeId = 0;
    private Number delayEndTime = 0;
    private int objectGID = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.delayTypeId);
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
         }
         param1.writeDouble(this.delayEndTime);
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
         param1.writeByte(this.delayTypeId);
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
         }
         param1.writeDouble(this.delayEndTime);
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
         super.serializeAs_HumanOption(param1);
         param1.writeByte(this.delayTypeId);
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element delayEndTime.");
         }
         param1.writeDouble(this.delayEndTime);
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.delayTypeId = param1.readByte();
         if(this.delayTypeId < 0)
         {
            throw new Exception("Forbidden value (" + this.delayTypeId + ") on element of HumanOptionObjectUse.delayTypeId.");
         }
         this.delayEndTime = param1.readDouble();
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element of HumanOptionObjectUse.delayEndTime.");
         }
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of HumanOptionObjectUse.objectGID.");
         }
    }

}