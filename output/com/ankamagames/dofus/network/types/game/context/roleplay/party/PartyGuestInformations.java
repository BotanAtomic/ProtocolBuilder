package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyGuestInformations extends Object implements INetworkType {

    private int protocolId = 374;
    private Number guestId = 0;
    private Number hostId = 0;
    private String name = "";
    private EntityLook guestLook;
    private int breed = 0;
    private boolean sex = false;
    private PlayerStatus status;
    private PartyCompanionBaseInformations[] companions;
    private FuncTree _guestLooktree;
    private FuncTree _statustree;
    private FuncTree _companionstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.guestId + ") on element guestId.");
         }
         param1.writeVarLong(this.guestId);
         if(this.hostId < 0 || this.hostId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.hostId + ") on element hostId.");
         }
         param1.writeVarLong(this.hostId);
         param1.writeUTF(this.name);
         this.guestLook.serializeAs_EntityLook(param1);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         param1.writeShort(this.status.getTypeId());
         this.status.serialize(param1);
         param1.writeShort(this.companions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.companions.length)
         {
            (this.companions[_loc2_] as PartyCompanionBaseInformations).serializeAs_PartyCompanionBaseInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PartyCompanionBaseInformations _loc5_ = null;
         this.guestId = param1.readVarUhLong();
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.guestId + ") on element of PartyGuestInformations.guestId.");
         }
         this.hostId = param1.readVarUhLong();
         if(this.hostId < 0 || this.hostId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.hostId + ") on element of PartyGuestInformations.hostId.");
         }
         this.name = param1.readUTF();
         this.guestLook = new EntityLook();
         this.guestLook.deserialize(param1);
         this.breed = param1.readByte();
         this.sex = param1.readBoolean();
         int _loc2_ = param1.readUnsignedShort();
         this.status = ProtocolTypeManager.getInstance(PlayerStatus,_loc2_);
         this.status.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
         {
            _loc5_ = new PartyCompanionBaseInformations();
            _loc5_.deserialize(param1);
            this.companions.push(_loc5_);
            _loc4_++;
         }
    }

}