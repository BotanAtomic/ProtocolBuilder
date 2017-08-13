package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayMutantInformations extends GameRolePlayHumanoidInformations implements INetworkType {

    private int protocolId = 3;
    private int monsterId = 0;
    private int powerLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayNamedActorInformations(param1);
         param1.writeShort(this.humanoidInfo.getTypeId());
         this.humanoidInfo.serialize(param1);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element monsterId.");
         }
         param1.writeVarShort(this.monsterId);
         param1.writeByte(this.powerLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayNamedActorInformations(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.humanoidInfo = ProtocolTypeManager.getInstance(HumanInformations,_loc2_);
         this.humanoidInfo.deserialize(param1);
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of GameRolePlayHumanoidInformations.accountId.");
         }
         this.monsterId = param1.readVarUhShort();
         if(this.monsterId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterId + ") on element of GameRolePlayMutantInformations.monsterId.");
         }
         this.powerLevel = param1.readByte();
    }

}