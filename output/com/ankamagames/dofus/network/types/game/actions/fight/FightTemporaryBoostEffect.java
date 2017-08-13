package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTemporaryBoostEffect extends AbstractFightDispellableEffect implements INetworkType {

    private int protocolId = 209;
    private int delta = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
         }
         param1.writeVarInt(this.uid);
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
         }
         param1.writeDouble(this.targetId);
         param1.writeShort(this.turnDuration);
         param1.writeByte(this.dispelable);
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
         }
         param1.writeVarShort(this.spellId);
         if(this.effectId < 0)
         {
            throw new Exception("Forbidden value (" + this.effectId + ") on element effectId.");
         }
         param1.writeVarInt(this.effectId);
         if(this.parentBoostUid < 0)
         {
            throw new Exception("Forbidden value (" + this.parentBoostUid + ") on element parentBoostUid.");
         }
         param1.writeVarInt(this.parentBoostUid);
         param1.writeShort(this.delta);
    }

    public void deserialize(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element of AbstractFightDispellableEffect.uid.");
         }
         this.targetId = param1.readDouble();
         if(this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.targetId + ") on element of AbstractFightDispellableEffect.targetId.");
         }
         this.turnDuration = param1.readShort();
         this.dispelable = param1.readByte();
         if(this.dispelable < 0)
         {
            throw new Exception("Forbidden value (" + this.dispelable + ") on element of AbstractFightDispellableEffect.dispelable.");
         }
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element of AbstractFightDispellableEffect.spellId.");
         }
         this.effectId = param1.readVarUhInt();
         if(this.effectId < 0)
         {
            throw new Exception("Forbidden value (" + this.effectId + ") on element of AbstractFightDispellableEffect.effectId.");
         }
         this.parentBoostUid = param1.readVarUhInt();
         if(this.parentBoostUid < 0)
         {
            throw new Exception("Forbidden value (" + this.parentBoostUid + ") on element of AbstractFightDispellableEffect.parentBoostUid.");
         }
         this.delta = param1.readShort();
    }

}