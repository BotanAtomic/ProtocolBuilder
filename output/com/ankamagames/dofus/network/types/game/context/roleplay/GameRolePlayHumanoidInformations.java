package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayHumanoidInformations extends GameRolePlayNamedActorInformations implements INetworkType {

    private int protocolId = 159;
    private HumanInformations humanoidInfo;
    private int accountId = 0;
    private FuncTree _humanoidInfotree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayActorInformations(param1);
         param1.writeUTF(this.name);
         param1.writeShort(this.humanoidInfo.getTypeId());
         this.humanoidInfo.serialize(param1);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
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
    }

}